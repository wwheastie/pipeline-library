@Grab('org.apache.commons:commons-math3:3.4.1')
import org.apache.commons.math3.primes.Primes

def call() {
  boolean isPrime = Primes.isPrime(3)
  sh "echo ${isPrime}"
}
