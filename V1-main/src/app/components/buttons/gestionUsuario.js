import Image from "next/image";
import Avatar from "../avatares/avatar";
export default function gestionUsuario({children}) {
    return (
      <div className=" cosa0 flex flex-row items-center justify-center">
        <Avatar />
        <button className="bg-[#e41b23] text-white px-2 py-2 hover:bg-red-700">
          <Image
            src="/flechaabajo.png"
            alt="Flecha abajo"
            width={32}
            height={32}
          />
          {children}
        </button>
      </div>
    );
  }
