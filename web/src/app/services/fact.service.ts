import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Fact } from "../models/fact";
import { map } from 'rxjs/operators';

@Injectable({providedIn: 'root'})
export class FactService {
    constructor(private http: HttpClient) {}

    getFacts(page:number): Observable<Fact[]> {
        return this.http.get<string[]>(`http://localhost:8080/facts?page=${page}`).pipe(
            map(facts => {
                return facts.map(s => new Fact(0, s))
            })
        );
    }

    getFavorites(): Observable<Fact[]> {
        return this.http.get<Fact[]>('http://localhost:8080/favorites');
    }

    addFavorite(fact: Fact): Observable<Fact> {
        return this.http.post<Fact>('http://localhost:8080/favorites', fact.fact);
    }

    removeFact(fact:Fact): Observable<void> {
        return this.http.delete<void>(`http://localhost:8080/favorites/${fact.id}`)
    }
}