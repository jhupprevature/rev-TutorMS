export class UserUpdate {
    id: string;
    firstName: string;
    lastName: string;
    schoolEmail: string;

    constructor(id: string, firstName: string, lastName: string, schoolEmail: string) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.schoolEmail = schoolEmail;
    }
}
