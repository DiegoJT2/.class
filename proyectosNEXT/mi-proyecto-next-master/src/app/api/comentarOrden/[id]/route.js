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
  if (!id) {
    return NextResponse.json({ error: "Falta el id" }, { status: 400 });
  }
  await pool.query("DELETE FROM ComentarioOrden WHERE id = ?", [id]);
  return NextResponse.json({ ok: true });
}