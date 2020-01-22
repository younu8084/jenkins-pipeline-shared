def call(){curl -u Megalai:Mumani1209@98  -X POST -H "Content-Type: application/json" -d '{

   "slug": "test",

   "forkable": false,

   "project": {

        "key": "DEMO"

    }

}' https://bitbucket.org.com/rest/api/2.0/projects/demo/repos/test
}
