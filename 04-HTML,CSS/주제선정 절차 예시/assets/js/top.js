$(window).on('scroll', () => {
    let scrollTop = $(window).scrollTop();

    if (scrollTop >= 200) {
        $("#top").fadeIn(300);
    } else {
        $("#top").fadeOut(300);
    }
});