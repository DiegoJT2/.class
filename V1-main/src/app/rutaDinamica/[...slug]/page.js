export default function Page({ params }) {
    const slug = params.slug || "";
    return (
      <div>
        <h1>Ruta Dináminca</h1>
        <p>Esto es una ruta dinámica en Next.js</p>
        <div>
            <h2>Slug Capturado</h2>
            <p>{slug}</p>
        </div>
      </div>
    );
  }
    