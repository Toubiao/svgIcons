import { TestBed } from '@angular/core/testing';

import { SvgIconsService } from './svg-icons.service';

describe('SvgIconsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SvgIconsService = TestBed.get(SvgIconsService);
    expect(service).toBeTruthy();
  });
});
