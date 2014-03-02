$(document).ready(function() {
	$('.logo_clicavel2').on( "click", function() {
		window.location = '/projeto_fiap_web'; 
	});
} );

function confirmacao(id){
    $( "#dialog-confirm" ).dialog({
        resizable: false,
        height:140,
        modal: true, 
        buttons: {
          "Sim": function() {
            $( this ).dialog( "close" );
            $(".objeto_" + id).click();
          },
          "Cancelar": function() {
            $( this ).dialog( "close" );
          }
        }
      });
}