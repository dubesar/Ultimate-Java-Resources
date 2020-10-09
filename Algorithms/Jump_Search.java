public static int jumpSearch(int[] arrayToSearch, int element) {
    int blockSize = (int) Math.floor(Math.sqrt(arrayToSearch.length));

    int currentLastIndex = blockSize-1;
    
    // Jump to next block as long as target element is > currentLastIndex
    // and the array end has not been reached
    while (currentLastIndex < arrayToSearch.length && element > arrayToSearch[currentLastIndex]) {
        currentLastIndex += blockSize;
    }

    // Find accurate position of target element using Linear Search
    for (int currentSearchIndex = currentLastIndex - blockSize + 1;
         currentSearchIndex <= currentLastIndex && currentSearchIndex < arrayToSearch.length; currentSearchIndex++) {
        if (element == arrayToSearch[currentSearchIndex]) {
            return currentSearchIndex;
        }
    }
    // Target element not found. Return negative integer as element position.
    return -1;
}
