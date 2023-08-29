class PseudoRandomNumber {
    final long MULTIPLIER = 1103515245;
    final long INCREMENT = 12345;
    final long MODULUS = (long) Math.pow(2, 31);

    long seed;

    PseudoRandomNumber(long seed) {
        this.seed = seed;
    }

    int nextInt() {
        seed = (MULTIPLIER * seed + INCREMENT) % MODULUS;
        return (int) seed;
    }

    int generateRandomNumber(int min, int max) {
        int range = max - min + 1;
        int randomNumber = nextInt() % range;
        if(randomNumber<0)randomNumber=randomNumber*-1;
        return randomNumber;
    }
}
