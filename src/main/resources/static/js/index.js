$(document).ready(function() {

    console.log("Carregou campanhas.js");

    let listaGanhadores = "";

    //Montar o objeto para realizar o filtro
    const filtro = new Object();
    (campanhas = ""),
    (produtos = ""),
    (serie = ""),
    (numero = ""),
    (data_corte_carta = ""),
    (data_corte_recusa = ""),
    (quantidade = "");

    $("#exportar").click(function() {

        //Realizar a request
        $.ajax({
            url: "/api/ganhadores/excel",
            type: "GET",
            cache: false,
            //data: filtro,
            beforeSend: function() {
                //$("#loader").show();
            },
            success: function(data) {

                //Converte os dados data em objeto blob
                var blob = new Blob(
                    [data],
                    {type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;base64,"}
                );

                //Cria o link de download e clicka nele
                var a = document.createElement("a");
                a.href = URL.createObjectURL(blob);
                a.download = "relatorio.xls";
                a.click();

            },
            error: function(xhr) {

                $(".alert").find(".message").text(xhr.responseText);
                $(".alert-danger").show();

            },
            complete: function() {
                //$("#loader").hide();
            },
        });

    });

});