// Karma configuration
// Generated on Fri Jul 05 2013 11:19:13 GMT-0400 (Eastern Daylight Time)


// base path, that will be used to resolve files and exclude
basePath = '../';


// list of files / patterns to load in the browser
files = [
  JASMINE,
  JASMINE_ADAPTER,
  'src/main/webapp/components/jquery-1.9.1.js',
  'src/main/webapp/components/angular.js',
  'src/main/webapp/components/angular-ui.js',
  'src/test/webapp/components/*.js',
  'src/main/webapp/js/**/*.js',
  'src/test/webapp/js/**/*.js',
];


// list of files to exclude
exclude = [
  
];


// test results reporter to use
// possible values: 'dots', 'progress', 'junit'
reporters = ['junit'];


junitReporter = {
	outputFile: 'test-output/jsUnitTests.xml',
	suite: 'unit'
};


// web server port
port = 9876;


// cli runner port
runnerPort = 9100;


// enable / disable colors in the output (reporters and logs)
colors = true;


// level of logging
// possible values: LOG_DISABLE || LOG_ERROR || LOG_WARN || LOG_INFO || LOG_DEBUG
logLevel = LOG_INFO;


// enable / disable watching file and executing tests whenever any file changes
autoWatch = true;


// Start these browsers, currently available:
// - Chrome
// - ChromeCanary
// - Firefox
// - Opera
// - Safari (only Mac)
// - PhantomJS
// - IE (only Windows)
browsers = ['Chrome', 'IE', 'Firefox'];


// If browser does not capture in given timeout [ms], kill it
captureTimeout = 60000;


// Continuous Integration mode
// if true, it capture browsers, run tests and exit
singleRun = false;
