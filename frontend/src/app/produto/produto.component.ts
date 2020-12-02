import { Component, Input, OnInit } from '@angular/core';
import { ProdutoModel } from '../model/produto-model';

@Component({
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.sass']
})
export class ProdutoComponent implements OnInit {

  @Input()
  produto: ProdutoModel

  constructor() { }

  ngOnInit() {
  }

}
