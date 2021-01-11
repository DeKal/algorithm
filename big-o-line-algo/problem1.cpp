//
//  main.cpp
//  big-o-line-algo
//
//  Created by Phat Ho on 1/11/21.
//

#include <iostream>
#include <algorithm>
using namespace std;

string getMax(string arr[], int n)
{
    string max = arr[0];

    for (int i = 1; i < n; i++)
    {
        if (max.length() < arr[i].length()) {
            max = arr[i];
        }
    }
        
    return max;
}
void print(string word, string words[], string meanings[], int n, int num)
{
    int i;
    for (i = 0; i < n; i++) {
        if (words[i].compare(word) == 0) {
            break;
        }
    }
    int currentFind = i;
    
    while (i < currentFind + num && i < n) {
        cout << words[i] << ": " << meanings[i] << endl;
        i++;
    }
  
}

void countSort(string words[], string meaning[], int size, size_t currentPos)
{

    string output[size];
    string subOutput[size];
    int count[257] = { 0 };
      
    
       for (int i = 0; i <size; i++){
           count[currentPos < words[i].size() ? (int)(unsigned char)words[i][currentPos] + 1 : 0]++;
       }

       for (int i = 1; i <257; i++){
           count[i] += count[i - 1];
       }

       for (int i = size - 1; i >= 0; i--){
           int countPos = currentPos < words[i].size() ? (int)(unsigned char)words[i][currentPos] + 1 : 0;
           output[count[countPos] - 1] = words[i];
           subOutput[count[countPos] - 1] = meaning[i];
           count[countPos]--;
       }

       for (int i = 0; i < size; i++){
           words[i] = output[i];
           meaning[i] = subOutput[i];
       }

}

void radixsort(string arr[], string meaning[], int n)
{
    string max = getMax(arr, n);
    for (size_t digit = max.length(); digit > 0; digit--)
    {
        countSort(arr, meaning, n, digit - 1);
    }
}
  

string words[100000];
string meanings[100000];
int n;

int main()
{
    cin >> n;
    string line;
    getline( cin, line );
    for (int i=0; i<n ; ++i) {
        string line;
        getline( cin, line );
        words[i] = line.substr(0, line.find(':'));
        meanings[i] = line.substr(line.find(':')+1, line.size());
    }

    radixsort(words, meanings, n);
    
    string find;
    cin >> find;
    
    print(find, words, meanings, n, 5);

    return 0;
}
