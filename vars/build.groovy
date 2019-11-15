def call(String msg = 'clean') {
echo "${msg}"
   sh 'mv clean install'
}
