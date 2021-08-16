import { AccountType } from "./AccountType"
import { Schedule } from "./Schedule";
import { Course } from "./Course";

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

    constructor(options?: {id?:number, firstName?: string, 
                username?:string, password?:string, accountType?:AccountType}) {
        if(!options) {
            options = {
                id: -1,
                firstName: 'Guest',
                username: 'Guest',
                password: '',
                accountType: new AccountType(4, 'Guest')
            }
        }
        this.id = options!.id || -1;
        this.firstName = options!.firstName || 'Guest';
        this.schoolEmail = options!.username || 'Guest'; 
        this.password = options!.password || '';
        this.accountType = options!.accountType || new AccountType(4, 'Guest');
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

// class Schedule {
//     id!: number;
//     sundayStart!: string;
//     sundayEnd!: string;
//     mondayStart!: string;
//     mondayEnd!: string;
//     tuesdayStart!: string;
//     tuesdayEnd!: string;
//     wednesdayStart!: string;
//     wednesdayEnd!: string;
//     thursdayStart!: string;
//     thursdayEnd!: string;
//     fridayStart!: string;
//     fridayEnd!: string;
//     saturdayStart!: string;
//     saturdayEnd!: string;
//     pendingApprovalSince!: number;
// }

// class Course {
//     id!: number;
//     name!: string;
//     subject!: string;
//     level!: number;
//     // hours!: number;
// }

// export const guestUser = new User({id:-1, firstName:'Guest', username:'Guest', password:''});
