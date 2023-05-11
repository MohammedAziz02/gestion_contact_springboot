// une fonction qui permet de soit afficher le modal quand la page est chargé completement
// donc lorsque l'utilisateur saisi quelques informations qui ne sont pas valide alors on doit le redirigié vers
// la page add.jsp et le modal doit pop up automatiquement pour cela j'ai utilisé les cookies. dans le controlleur
// quand on trouve un erreur dans BindingResult on ajoute une cookie = ModalShown:true; alors on fait un test ici
// dans cette fonction et quand on a pas d'erreur on doit dans le controlleur attribuer à ModalShown=> null pour le supprimer
$(document).ready(function() {

    if (document.cookie.split(';').some((item) => item.trim().startsWith('modalShownadd=true'))) {
        $('#addcontact').modal('show');
    }else{
        $('#addcontact').modal('hide');
    }

    if (document.cookie.split(';').some((item) => item.trim().startsWith('modalShownupdate=true'))) {
        $('#updatecontact').modal('show');
    }else{
        $('#updatecontact').modal('hide');
    }
    console.log("hi from test.js");

    // une événement lors de la clique sur la button modifier de Contact un Modal (formulaire) doit se surgis
    // avec les informations du ligne
    $(".modifier").click(function() {
        console.log("clicked me");
        var contactId = $(this).data("id");
        console.log(contactId);
        var contactRow = $(this).closest("tr");
        var nom = contactRow.find("td:eq(0)").text();
        var prenom = contactRow.find("td:eq(1)").text();
        var genre = contactRow.find("td:eq(2)").text();
        var adresse = contactRow.find("td:eq(3)").text();
        var telephone1 = contactRow.find("td:eq(4)").text();
        var telephone2 = contactRow.find("td:eq(5)").text();
        var email1 = contactRow.find("td:eq(6)").text();
        var email2 = contactRow.find("td:eq(7)").text();

        $('form[name="formupdate"] input[name="id_Contact"]').val(contactId);
        $('form[name="formupdate"] input[name="nom"]').val(nom);
        $('form[name="formupdate"] input[name="prenom"]').val(prenom);
        $('form[name="formupdate"] input[name="genre"]').val(genre);
        $('form[name="formupdate"] input[name="adress"]').val(adresse);
        $('form[name="formupdate"] input[name="telephone1"]').val(telephone1);
        $('form[name="formupdate"] input[name="telephone2"]').val(telephone2);
        $('form[name="formupdate"] input[name="emailpersonnel"]').val(email1);
        $('form[name="formupdate"] input[name="emailprofessional"]').val(email2);
        $("#updatecontact").modal("show");
    });

});

(function ($) {
    "use strict";
    var fullHeight = function () {
        $(".js-fullheight").css("height", $(window).height());
        $(window).resize(function () {
            $(".js-fullheight").css("height", $(window).height());
        });
    };
    fullHeight();
    $("#sidebarCollapse").on("click", function () {
        $("#sidebar").toggleClass("active");
    });
})(jQuery);

