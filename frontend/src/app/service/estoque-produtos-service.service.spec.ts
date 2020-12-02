import { TestBed } from '@angular/core/testing';

import { EstoqueProdutosServiceService } from './estoque-produtos-service.service';

describe('EstoqueProdutosServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EstoqueProdutosServiceService = TestBed.get(EstoqueProdutosServiceService);
    expect(service).toBeTruthy();
  });
});
