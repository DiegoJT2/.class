import { NextResponse } from "next/server";
import pool from "../lib/db";

// Obtener comentarios de una orden
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

// Añadir comentario a una orden
export async function POST(req) {
  const { numeroCompra, texto } = await req.json();
  await pool.query(
    "INSERT INTO ComentarioOrden (numero_compra, texto) VALUES (?, ?)",
    [numeroCompra, texto]
  );
  return NextResponse.json({ ok: true });
}