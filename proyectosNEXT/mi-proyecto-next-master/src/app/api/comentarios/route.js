import { NextResponse } from "next/server";
import pool from "@/app/api/lib/db";

export async function POST(req) {
  const body = await req.json();
  const numeroCompra = body.numeroCompra;
  const texto = body.texto;
  const fecha = new Date();

  if (!numeroCompra || !texto) {
    return NextResponse.json({ error: "Faltan datos" }, { status: 400 });
  }

  await pool.query(
    "INSERT INTO ComentarioOrden (numero_compra, texto, fecha) VALUES (?, ?, ?)",
    [numeroCompra, texto, fecha]
  );

  return NextResponse.json({ ok: true });
}

export async function GET(req) {
  const { searchParams } = new URL(req.url);
  const numeroCompra = searchParams.get("numeroCompra");
  if (!numeroCompra) {
    return NextResponse.json([], { status: 200 });
  }
  const [rows] = await pool.query(
    "SELECT * FROM ComentarioOrden WHERE numero_compra = ? ORDER BY fecha DESC",
    [numeroCompra]
  );
  return NextResponse.json(rows);
}