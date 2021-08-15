export const fakeIn : Date = new Date(0);
fakeIn.setHours(10);
  
export const fakeOut : Date = new Date(0);
fakeOut.setHours(18);

export const workedHours: Array<any> = [
    { "day": "Sunday",    "inTime": "---",  "outTime": "---"},
    { "day": "Monday",    "inTime": fakeIn, "outTime": fakeOut},
    { "day": "Tuesday",   "inTime": fakeIn, "outTime": fakeOut},
    { "day": "Wednesday", "inTime": fakeIn, "outTime": fakeOut},
    { "day": "Thursday",  "inTime": fakeIn, "outTime": fakeOut},
    { "day": "Friday",    "inTime": fakeIn, "outTime": fakeOut},
    { "day": "Saturday",  "inTime": "---",  "outTime": "---"}
  ]

export interface User {
    id : number,
    firstName : string,
    lastName : string,
    schoolEmail : string,
    password : string,
    phoneNumber : string,
    accountType : any
}

export const tutorUser: User = {
    id: 42,
    firstName: "Mickey",
    lastName: "Mouse",
    schoolEmail: "mmouse0",
    password: "pa$$word",
    phoneNumber : "555-867-5309",
    accountType: {
        id: 2,
        type: "Tutor"
    }
}

export const studentUser: User = {
    id: 52,
    firstName: "Daisy",
    lastName: "Duck",
    schoolEmail: "dduck4",
    password: "pa$$word",
    phoneNumber: "555-123-4567",
    accountType: {
        id: 3,
        type: "Student"
    }
}
