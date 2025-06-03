import { useState, useEffect } from "react";

export default function ComentariosOrden({ numeroCompra, labelInput = "Añadir un comentario" }) {
  const [comentarios, setComentarios] = useState([]);
  const [nuevoComentario, setNuevoComentario] = useState("");
  const [editandoId, setEditandoId] = useState(null);
  const [textoEditado, setTextoEditado] = useState("");

  // Función única para recargar comentarios
  const cargarComentarios = () => {
    fetch(`/api/comentarOrden?numeroCompra=${numeroCompra}`)
      .then(res => res.json())
      .then(setComentarios);
  };

  // Cargar comentarios al montar o cambiar numeroCompra
  useEffect(() => {
    cargarComentarios();
  }, [numeroCompra]);

  // Añadir comentario
  const agregarComentario = async () => {
    if (!nuevoComentario.trim()) return;
    await fetch(`/api/comentarOrden`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ texto: nuevoComentario, numeroCompra }),
    });
    setNuevoComentario("");
    cargarComentarios();
  };

  // Eliminar comentario
  const eliminarComentario = async (id) => {
    await fetch(`/api/comentarOrden/${id}`, { method: "DELETE" });
    cargarComentarios();
  };

  // Editar comentario
  const guardarEdicion = async (id) => {
    await fetch(`/api/comentarOrden/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ texto: textoEditado }),
    });
    setEditandoId(null);
    setTextoEditado("");
    cargarComentarios();
  };

  return (
    <div className="mt-8">
      <h3 className="font-bold mb-2">Comentarios</h3>
      <div className="mb-4 flex gap-2">
        <input
          type="text"
          value={nuevoComentario}
          onChange={e => setNuevoComentario(e.target.value)}
          className="border p-2 rounded flex-1"
          placeholder={labelInput}
        />
        <button onClick={agregarComentario} className="bg-[#e41b23] text-white px-3 py-1 rounded hover:bg-red-900">
          Añadir
        </button>
      </div>
      <ul>
        {comentarios.map(c => (
          <li key={c.id} className="mb-2 flex items-center gap-2">
            {editandoId === c.id ? (
              <>
                <input
                  value={textoEditado}
                  onChange={e => setTextoEditado(e.target.value)}
                  className="border p-1 rounded flex-1"
                />
                <button onClick={() => guardarEdicion(c.id)} className="text-green-600">Guardar</button>
                <button onClick={() => setEditandoId(null)} className="text-gray-600">Cancelar</button>
              </>
            ) : (
              <>
                <span className="flex-1">{c.texto}</span>
                <button onClick={() => { setEditandoId(c.id); setTextoEditado(c.texto); }} className="text-blue-600">Editar</button>
                <button onClick={() => eliminarComentario(c.id)} className="text-red-600">Eliminar</button>
              </>
            )}
          </li>
        ))}
      </ul>
    </div>
  );
}