import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FactService } from './services/fact.service';
import { Fact } from './models/fact';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit {
  title = 'Cat Facts';
  facts: Fact[] = []
  favorites: Fact[] = []
  page: number = 1

  constructor(private factService: FactService) {}

  ngOnInit(): void {
    this.getFacts();
    this.getFavorites();
  }

  addFavorite(fact: Fact): void {
    this.factService.addFavorite(fact).subscribe( fact => this.favorites.push(fact))
  }

  removeFavorite(fact: Fact): void {
    const index = this.favorites.findIndex(f => f.fact === fact.fact);

    this.factService.removeFact(this.favorites[index]).subscribe(
      _ => this.favorites.splice(index, 1)
    )
  }

  isFavorite(fact:Fact): boolean {
    return this.favorites.some(f => f.fact === fact.fact)
  }

  nextPage(): void {
    if(this.page >= 34)
      return;

    this.page++;
    this.getFacts();
  }

  previousPage(): void {
    if(this.page <= 1)
      return

    this.page--;
    this.getFacts()
  }

  private getFacts():void {
    this.factService.getFacts(this.page).subscribe(facts => this.facts = facts)
  }

  private getFavorites(): void {
    this.factService.getFavorites().subscribe(favorites => this.favorites = favorites)
  }
}
