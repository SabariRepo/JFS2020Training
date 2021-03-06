import { DataService2 } from './data.service2';
import { Injectable, EventEmitter } from '@angular/core';
import { Book } from './Book';
//import { Subject } from 'rxjs';

@Injectable({
  providedIn: "root"
})
export class DataService{

  public books: Array<Book>;

  //Observable and Observer
  bookAddedEvent = new EventEmitter<Book>();

  bookDeletedEvent = new EventEmitter<Book>();
  //bookAddedEvent = new Subject<Book>();


   constructor(){
    //used to trigger the event
    this.books = new Array<Book>();

    const book1 = new Book('first book', 'Matt', 5.9);
    const book2 = new Book('second book', 'James', 3.5);
    const book3 = new Book('third book', 'Philip', 8.7);
    const book4 = new Book('fourth book', 'John', 7.7);
    this.books.push(book1);
    this.books.push(book2);
    this.books.push(book3);
    this.books.push(book4);

   }

   addBook(book:Book){
    this.books.push(book);
    //Fire the Event
    //Observable object is created
    //and using that Object an Event is fired
    this.bookAddedEvent.emit(book);
   }

   deleteLastBook(){

   let book:Book = this.books.pop();
    this.bookDeletedEvent.emit(book);
   }
}
