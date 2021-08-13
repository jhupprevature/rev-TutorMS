export class User {
    id: number;
    schoolEmail: String;
    password: String;
    firstName?: String;
    accountType?: AccountType;

    constructor(id:number, username:String, password:String) {
        this.id = id;
        this.schoolEmail = username; 
        this.password = password;
    }
}

class AccountType {
    id: number;
    type: String;

    constructor(id: number, type: String) {
        this.id = id;
        this.type = type;
    }
}