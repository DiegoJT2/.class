"use client";
import { useState } from "react";
import Image from "next/image";
export default function Sidebar() {
    const [searchQuery, setSearchQuery] = useState("");

    const handleSearchChange = (e) => {
    setSearchQuery(e.target.value);
    console.log("Buscando:", e.target.value); // Aquí puedes agregar la lógica de búsqueda
    };
return (
    <div className="sidebar">
      
      {/* Menú de navegación */}
      <ul className="menu">
        <li className="text-gray-600">Gestión de Bolsas</li>
        <li><strong>Home</strong></li>
        
        <li><a href="#" ><Image
          src="/inicio.png"
          alt="foto"
          width={30}
          height={30}
        /> Inicio</a></li>
        
        <div className="search-container">
        <input
          type="text"
          value={searchQuery}
          onChange={handleSearchChange}
          placeholder="Buscar"
          className="search-input"
        /> {/* Barra de búsqueda */}
        </div>
      
        <li><a href="#"><Image
          src="/ajustes.png"
          alt="foto"
          width={25}
          height={25}
        /> Ajustes</a></li>
        
        <li><a href="#"><Image
          src="/soporte.png"
          alt="foto"
          width={25}
          height={25}
        /> Soporte Técnico</a></li>
      </ul>
    </div>
  );
}
