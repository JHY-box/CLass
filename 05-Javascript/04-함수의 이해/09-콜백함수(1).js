function onDelivered(action) {
    console.log("배달 도착!");
    action();
}

function customer1() {
    console.log("문 앞에 두세요.");
}

function customer2() {
    console.log("직접 받을게요.");
}

onDelivered(customer1);
onDelivered(customer2);