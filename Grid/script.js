const grid = new gridjs.Grid({
    search:true,
    sort:true,
    resizable: true,
    pagination:{
        limit: 10,

    },
    fixedHeader:true,
    style:{
        th: {
            'background-color': '#512da8',
            'color': 'white',
            'text-align': 'center'
        },
        td: {
            'text-align': 'center'
        }
    },
    columns: ['Id', 'Nombre', 'Apellido', 'Email', 'Género', 'Ip', 'País'],
    server:{
        url: 'http://localhost:8080/api/customer',
        then: data => {
            //console.log(data);
            return data.map(item => [
                item.id,
                item.first_name,
                item.last_name,
                item.email,
                item.gender,
                item.ip_address,
                item.country
            ])
        }
    }
}).render(document.getElementById('wrapper'));

