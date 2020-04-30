
job('Bake_Jenkins_Container') {
    
    wrappers {
        environmentVariables {
            env('SCOPE', 'nick')
        }
        credentialsBinding {
            string('GH_PAT', 'GH_PAT')
            string('GH_CLIENT_ID', 'GH_CLIENT_ID')
            string('GH_CLIENT_SECRET', 'GH_CLIENT_SECRET')
        }
    }

    scm {
        git {
            remote {
                github('ProgrammerNick/jenkins', 'https')
                credentials('GH_PAT')
            }
            branch('master')
        }
    }
    
    steps {
        shell("docker build . -t ${SCOPE}/jenkins")
    }
}