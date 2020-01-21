def call(){
httpRequest authentication: 'Megalai', contentType: 'APPLICATION_JSON', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']], httpMode: 'POST', requestBody: '''{
    "name": "test_123",
    "scmId": "git",
    "forkable": true
}''', responseHandle: 'NONE', url: 'http://api.bitbucket.org/Megalai/rest/api/1.0/projects/DEM/repos'
}
