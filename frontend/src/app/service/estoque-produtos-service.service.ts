import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { ProdutoModel } from '../model/produto-model';

@Injectable({
  providedIn: 'root'
})
export class EstoqueProdutosServiceService {

  constructor(private http: HttpClient) { }

  getProdutos(): Observable<Array<ProdutoModel>>{
    return this.http.get<Array<ProdutoModel>>('http://localhost:9000/produtos/estoque');
  }
}
