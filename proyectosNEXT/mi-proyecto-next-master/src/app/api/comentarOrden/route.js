import { NextResponse } from "next/server";
import pool from "../../lib/db";

// Obtener comentarios
export async function GET(req, { params }) {
  const { numeroCompra } = params;
  const [rows] = await pool.query(
    "SELECT * FROM ComentarioOrden WHERE numero_compra = ? ORDER BY fecha DESC",
    [numeroCompra]
  );
  return NextResponse.json(rows);
}
// Añadir comentario
export async function POST(req, { params }) {
  const { numeroCompra } = params;
  const { texto } = await req.json();
  await pool.query(
    "INSERT INTO ComentarioOrden (numero_compra, texto) VALUES (?, ?)",
    [numeroCompra, texto]
  );
  return NextResponse.json({ ok: true });
}
import { NextResponse } from "next/server";
import pool from "../../lib/db";

// Editar comentario
export async function PUT(req, { params }) {
  const { id } = params;
  const { texto } = await req.json();
  await pool.query("UPDATE ComentarioOrden SET texto = ? WHERE id = ?", [texto, id]);
  return NextResponse.json({ ok: true });
}

// Eliminar comentario
export async function DELETE(req, { params }) {
  const { id } = params;
  await pool.query("DELETE FROM ComentarioOrden WHERE id = ?", [id]);
  return NextResponse.json({ ok: true });
}