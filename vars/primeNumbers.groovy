@Grab('org.apache.commons:commons-math3:3.4.1')
import org.apache.commons.math3.primes.Primes

def call() {
  var isPrime = Primes.isPrime(1)
  sh "echo ${isPrime}"
}
