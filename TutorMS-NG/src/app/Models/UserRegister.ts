import { AccountType } from "src/app/Models/AccountType";


export class UserRegister {
    firstName: string;
    lastName: string;
    schoolEmail: string;
    password: string;
    phoneNumber: string;
    accountType: AccountType;
    schedule: null;

    constructor(firstName: string, lastName: string, schoolEmail: string, password: string, phoneNumber: string, accountType: AccountType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.schoolEmail = schoolEmail;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.accountType = accountType;
    }
}

