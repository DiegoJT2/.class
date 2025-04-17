import Image from "next/image";
import CerrarSesion from "../buttons/cerrarSesion";
import GestiónUsuario from "../buttons/gestionUsuario";
export default function Header() {

    return (
      < >
      <div className=" cosaGrande bg-[#e41b23]">
        <div className=" cosa1  flex">
          <Image
            src="/logoSalesianosZaragoza.jpeg"
            alt="foto"
            width={170}
            height={50}
          /> 
          <CerrarSesion>Cerrar Sesión</CerrarSesion>
        </div>
        <GestiónUsuario/>
      </div>
      </> 
    );
  }
    