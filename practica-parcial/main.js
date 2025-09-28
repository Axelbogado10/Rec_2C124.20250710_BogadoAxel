console.log("hola");
/*
- id
- nombre
- precio
- ruta_img
*/

let productosTienda = 
[
{id:1, nombre:"monitor 32k", precio:1000, ruta_img:"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.alternate.de%2Fp%2F160x160%2F0%2F4%2FAcer_Nitro_KG282K__Gaming_Monitor%40%401714340.jpg&f=1&nofb=1&ipt=3164c0315a18feb1561a749085c156c27e1d7bb1c93e2a9c9029c58bff327cab"},
{id:2, nombre:"mouse", precio:200, ruta_img:"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.cyberpuerta.mx%2Fimg%2Fproduct%2FS%2FCP-RAZER-RZ01-04000100-R3U1-89e889.jpg&f=1&nofb=1&ipt=529c9537cd983f8e14c0d2ca8cb0d7c9382b279ec9f502a7c510e1f60a8dcbe7"},
{id:3, nombre:"parlante", precio:400, ruta_img:"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.heavenimagenes.com%2Fheavencommerce%2Fd86f9793-89bd-4e00-8fd3-fdfdc49c7186%2Fimages%2Fv2%2FNOGA%2F9588_small.jpg&f=1&nofb=1&ipt=4fe5de45b44ef7ee8c6c10eb35a4a6431b9738cc28cf689fb5baf676f0daab3c"},
{id:4, nombre:"teclado", precio:500, ruta_img:"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%2Fid%2FOIP.OQJje4U2Gu89hh8Hr5lebQAAAA%3Fpid%3DApi&f=1&ipt=7c4f68062a959e1537340ea45a6447baa55b2d8890d1c36fb7e8bc84dc887d88"},
{id:5, nombre:"mousePad", precio:100, ruta_img:"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse4.mm.bing.net%2Fth%2Fid%2FOIP.rdiN2IlzllcffH_aQYTPcwAAAA%3Fpid%3DApi&f=1&ipt=1fb5197b5a71b43ee9a318655343a4c16f69ccec8f7fed2f7540fa8339a3daf6"},
{id:6, nombre:"auriculares", precio:350, ruta_img:"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fthumb.pccomponentes.com%2Fw-150-150%2Farticles%2F1081%2F10817488%2F1501-tempest-ghs400-inquisitor-auriculares-gaming-rgb-wireless-pc.jpg&f=1&nofb=1&ipt=53718ebee81d00704792b0022f084af7b258d0b22f36341c53026513ea83001b"},
]

console.table(productosTienda)
console.log(productosTienda)

let listadoProductos = document.getElementById("listadoProductos");
let cartaProducto = "";

//console.log(cartaProducto);


let barraBusqueda = document.getElementById("barraBusqueda");
barraBusqueda.addEventListener("keyup", function(){
    let valorBusqueda = barraBusqueda.value;
    console.log(valorBusqueda);
    /* funcion flecha con multiples argumentos
    let productosFiltrados = productosTienda.filter(producto => {
        return producto.nombre.includes(valorBusqueda);
        })*/
       let productosFiltrados = productosTienda.filter(producto => producto.nombre.includes(valorBusqueda))
       console.table(productosFiltrados);
       mostrarProductos(productosFiltrados);
    })
    
function mostrarProductos(array){
    //listadoProductos.innerHTML = "";
    cartaProducto = ""; //necesario resetear los divs previos
    array.forEach(producto =>{
        cartaProducto += `
            <div class="card-producto">
            <img src="${producto.ruta_img}" alt="">
            <h3>${producto.nombre}</h3>
            <p>$${producto.precio}</p>
            <button>Agregar al carrito</button>
            </div> 
            `;
        });
    listadoProductos.innerHTML = cartaProducto;
}
    
mostrarProductos(productosTienda);
    /*
    <div class="card-producto">
    <img src="" alt="">
    <h3></h3>
    <p>$</p>
    <button>Agregar al carrito</button>
    </div> 
    */