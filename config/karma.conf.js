basePath = '../';

files = [
  JASMINE,
  JASMINE_ADAPTER,
  'src/main/webapp/components/angular.js',
  'src/test/webapp/components/angular-mocks.js',
  'src/main/webapp/js/**/*.js',
  'src/test/webapp/js/**/*.js'
];

autoWatch = true;

browsers = ['Chrome'];

junitReporter = {
  outputFile: 'test_out/unit.xml',
  suite: 'unit'
};
