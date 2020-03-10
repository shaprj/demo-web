$("#table tr").click(function(){
    $(this).addClass('selected').siblings().removeClass('selected');
    var id=$(this).find('td:first').html();
    var startDate = $(this).find('#contract_start_date').html();
    var endDate = $(this).find('#contract_end_date').html();
    var user = $(this).find('#contract_user').html();
    var product = $(this).find('#contract_product').html();
    $('#contract-id').val(id);
    $('#contract-start-date').val(startDate);
    $('#contract-end-date').val(endDate);

    $("#contract-user option").each(function(){
        if($(this).text() == user){
            $("#contract-user").val($(this).val());
        }
    });
    $("#contract-product option").each(function(){
        if($(this).text() == product){
            $("#contract-product").val($(this).val());
        }
    });
});

function createModel () {

    var model = {
        id: $('#contract-id').val(),
        start_date: $('#contract-start-date').val(),
        end_date : $('#contract-end-date').val(),
        user: $('#contract-user').val(),
        product: $("#contract-product").val()
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
    var value = $(this).val();

      var model_filter = {
          filter: value,
          _csrf: "hardcoded",
      };

    $.post("all/filtered", model_filter, function(res){
        location.reload();
    });
  });
});