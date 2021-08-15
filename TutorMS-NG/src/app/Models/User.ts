import { AccountType } from "./AccountType";

export class User {
    id: number;
    firstName: string;
    lastName?: string;
    schoolEmail: string;
    password: string;
    phoneNumber?: string;
    accountType: AccountType;
    schedule?: Schedule;
    courses?: Course[];

    constructor(id:number, firstName: string, username:string, password:string) {
        this.id = id;
        this.firstName = firstName;
        this.schoolEmail = username; 
        this.password = password;
        this.accountType = new AccountType(4, 'Guest');
    }

}

// class AccountType {
//     id: number;
//     type: string;

//     constructor(id: number, type: string) {
//         this.id = id;
//         this.type = type;
//     }
// }

class Schedule {
    id!: number;
    sundayStart!: string;
    sundayEnd!: string;
    mondayStart!: string;
    mondayEnd!: string;
    tuesdayStart!: string;
    tuesdayEnd!: string;
    wednesdayStart!: string;
    wednesdayEnd!: string;
    thursdayStart!: string;
    thursdayEnd!: string;
    fridayStart!: string;
    fridayEnd!: string;
    saturdayStart!: string;
    saturdayEnd!: string;
    pendingApprovalSince!: number;
}

class Course {
    id!: number;
    name!: string;
    subject!: string;
    level!: number;
    // hours!: number;
}

export const guestUser = new User(-1, 'Guest', 'guest', '');