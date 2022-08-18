def call(Map config = [:], Closure body) {
  var isPrime = Primes.isPrime(1)
  sh "echo ${isPrime}"
}
