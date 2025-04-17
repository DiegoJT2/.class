
export default function CerrarSesion({children}) {
  return (
    <button className="bg-black text-white px-4 py-2 rounded hover:bg-gray-600 mr-7 p-6">
      {children}
    </button>
  );
}