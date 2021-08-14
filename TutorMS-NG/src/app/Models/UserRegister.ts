import { AccountType } from "./AccountType";

export class UserRegister {
    firstName: String;
    lastName: String;
    schoolEmail: String;
    password: String;
    phoneNumber: String;
    accountType: AccountType;
    schedule: null;

    constructor(firstName: String, lastName: String, schoolEmail: String, password: String, phoneNumber: String, accountType: AccountType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.schoolEmail = schoolEmail;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.accountType = accountType;
    }
}

