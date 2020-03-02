$("#table tr").click(function(){
   $(this).addClass('selected').siblings().removeClass('selected');
   var id=$(this).find('td:first').html();
   var name = $(this).find('#user_name').html();
   var login = $(this).find('#user_login').html();
   var age = $(this).find('#user_age').html();
   var male = $(this).find('#user_is_male').html();
   $('#user-id').val(id);
   $('#user-name').val(name);
   $('#user-login').val(login);
   $('#user-age').val(age);
   if(male == "true"){
        $("#user-is-male").val('true');
   } else {
        $("#user-is-male").val('false');
   }
});

function createModel () {

    var male;

    if($("#user-is-male").val() == "true"){
        male = true;
    } else {
        male = false;
    }

    var model = {
                    id: $('#user-id').val(),
                    name: $('#user-name').val(),
                    login : $('#user-login').val(),
                    age: $('#user-age').val(),
                    male: $('#user-is-male').val()
                    };
     return model;
}

$("#onCreate").click(function(){

    var model = createModel();

    $.post("create", model, function(res){
        location.reload();
    });
});

$("#onUpdate").click(function(){

    var model = createModel();

    $.post("update", model, function(res){
        location.reload();
    });
});

$("#onDelete").click(function(){

    var model = createModel();

    $.post("delete", model, function(res){
        location.reload();
    });
});

$(document).ready(function(){
  $("#search-text-field").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#filtered-table tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});

$('.ok').on('click', function(e){
    alert($("#table tr.selected td:first").html());
});