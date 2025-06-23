const member = {
    name: 'Lee',
    
    age: 21,
    
    sayKor: function() {
        return `나는 ${this.name}입니다.`;
    },
    
    sayEng: () => `I'm ${member.age} years old.`
}
    
console.log(member.sayKor());
console.log(member.sayEng());


