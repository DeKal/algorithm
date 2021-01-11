//
//  problem3.cpp
//  big-o-line-algo
//
//  Created by Phat Ho on 1/11/21.
//

#include <stdio.h>
#include <iostream>
#include <stack>
#include <algorithm>
#include <algorithm>
#include <functional>
#include <cctype>
#include <locale>


using namespace std;


const string TEXT = "text";
const string LINK = "link";
const string IMAGE = "image";
const string MEDIA = "media";

string results[100000];
int lineIndex = 0;
stack<string> lineStack;
int collapseStack[100000];
string allLines = "";


void ltrim(string &s) {
    s.erase(s.begin(), find_if(s.begin(), s.end(),
        not1(ptr_fun<int, int>(isspace))));
}

void rtrim(string &s) {
    s.erase(find_if(s.rbegin(), s.rend(),
        not1(ptr_fun<int, int>(isspace))).base(), s.end());
}

void trim(string &s) {
    ltrim(s);
    rtrim(s);
}

void replaceAll(string & data, string toSearch, string replaceStr)
{
    size_t pos = data.find(toSearch);
    while( pos != std::string::npos)
    {
        data.replace(pos, toSearch.size(), replaceStr);
        pos =data.find(toSearch, pos + replaceStr.size());
    }
}

string getMode(string &s) {
    int i;
    string mode = "";
    
    for (i=0; i<6; ++i) {
       
        if (s[i] != ':') {
            mode += s[i];
        } else {
            break;
        }
    }
    if (!mode.compare(LINK) || !mode.compare(MEDIA) || !mode.compare(IMAGE) ) {
        s = s.substr(i + 1, s.length());
        return mode;
    }

    return "text";
}

void read() {
    string line;
    while (getline(cin, line))
    {
        allLines += line;
    }
    replaceAll(allLines, "[[[", "{");
    replaceAll(allLines, "[[", "[");
    replaceAll(allLines, "]]]", "}");
    replaceAll(allLines, "]]", "]");
    allLines += ']';
    int collapseLevel = -1;
    
    line = "";
    int i = 0;
    fill_n(collapseStack, 100000, 0);
    
    do {
        if (allLines[i] != '[' && allLines[i] !='{' && allLines[i] !='}' && allLines[i] !=']') {
            line += allLines[i];
        } else {
            trim(line);
            if (line.length()) {
                string mode = getMode(line);
                if (!lineStack.empty()) {
                    results[lineIndex++] = lineStack.top() + ":" + mode + ": " + line;
                } else {
                    results[lineIndex++] = mode + ": " + line;
                }
                line = "";
            }
        }
        if (allLines[i] == '{') {
        
            if (!lineStack.empty()) {
                collapseLevel++;
                collapseStack[collapseLevel]++;
                lineStack.push(lineStack.top() + "_" + to_string(collapseStack[collapseLevel]));
            } else {
                collapseLevel++;
                collapseStack[collapseLevel]++;
                lineStack.push("collapse_" + to_string(collapseStack[collapseLevel]));
            }
            results[lineIndex++] = lineStack.top() + ": start";
            
            i+=9;
        }  else if (allLines[i] == '}') {
            collapseStack[collapseLevel + 1] = 0;
            collapseLevel--;
            results[lineIndex++] = lineStack.top() + ": end";
            lineStack.pop();
        }
        
        ++i;
        
    } while(i < allLines.length());
    
 

}

int main() {
    
    read();

    for (int i = 0; i < lineIndex; i++) {
        cout << results[i] << endl;
    }
    return 0;

}
