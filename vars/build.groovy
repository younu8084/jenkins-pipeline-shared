def call(String msg = 'clean') {
echo "${msg}"
   sh 'mvnn clean install'
}
