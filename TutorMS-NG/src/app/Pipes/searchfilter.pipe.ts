import { Pipe, PipeTransform } from '@angular/core';
import { Tutor } from '../Models/tutor';

@Pipe({
  name: 'searchfilter'
})
export class SearchfilterPipe implements PipeTransform {

  transform(tutors: Tutor[], searchBox: string): Tutor[] {
    
    if(!tutors || !searchBox){
      return tutors;
    }
    return tutors.filter(tutor => 
      tutor.id.toString().toLocaleLowerCase().includes(searchBox.toLocaleLowerCase()) ||
      tutor.firstName.toLocaleLowerCase().includes(searchBox.toLocaleLowerCase()) ||
      tutor.schoolEmail.toLocaleLowerCase().includes(searchBox.toLocaleLowerCase())
      );
  }

}
