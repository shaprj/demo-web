$("#table tr").click(function(){
   $(this).addClass('selected').siblings().removeClass('selected');
   var id=$(this).find('td:first').html();
   var name = $(this).find('#product_name').html();
   var description = $(this).find('#product_description').html();
   var productType = $(this).find('#product_type').html();
   var price = $(this).find('#product_price').html();
   $('#product-id').val(id);
   $('#product-name').val(name);
   $('#product-description').val(description);
   $('#product-price').val(price);
   $("#product-type option").each(function(){
       if($(this).text() == productType){
            $("#product-type").val($(this).val());
       }
   });
});

function createModel () {

    var model = {
                    id: $('#product-id').val(),
                    name: $('#product-name').val(),
                    description : $('#product-description').val(),
                    price: $('#product-price').val(),
                    productTypeId: $("#product-type").val()
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