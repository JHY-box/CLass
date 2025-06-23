$(".key").on('mouseenter mouseleave', e => {
    $(e.currentTarget).find('.open').fadeToggle(300);
})

$("#top_menu_item").on('click', e => {
    $(e.currentTarget).next().slideToggle(300);
})

$("#login_member_pc").on('click', e => {
    let current = $(e.currentTarget);
    current.next().slideToggle(300);
    
    let one = current.find('#first').attr('src');
    let two = current.find('#second').attr('src');

    current.find('#first').attr('src', two);
    current.find('#second').attr('src', one);
})

$("#login_member").on('click', e => {
    let current = $(e.currentTarget);
    current.next().slideToggle(300);
    
    let one = current.find('#o').attr('src');
    let two = current.find('#x').attr('src');

    current.find('#o').attr('src', two);
    current.find('#x').attr('src', one);

    if (current.parent().css('background-color') == 'rgba(0, 0, 0, 0)') {
        current.parent().css('background-color', 'rgb(47, 28, 17)');
    } else {
        current.parent().css('background-color', 'rgba(0, 0, 0, 0)');
    }
})