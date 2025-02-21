#include <iostream>
#include <fstream>
#include <map>
#include <string>
#include <iomanip>

using namespace std;

// Function to count the frequency of items in the file
map<string, int> CountFrequency(const string& filename) {
	ifstream inFile(filename);
	map<string, int> frequencyMap;
	string word;

	if (!inFile.is_open()) {
		cout << "Error: Unable to open file " << filename << endl;
		return frequencyMap;
	}

	while (inFile >> word) {
		frequencyMap[word]++;
	}

	inFile.close();
	return frequencyMap;
}

// Function to search for the frequency of a specific item
void SearchItemFrequency(const map<string, int>& frequencyMap) {
	string item;
	cout << "Enter the item to search for: ";
	cin >> item;

	if (frequencyMap.find(item) != frequencyMap.end()) {
		cout << "The item '" << item << "' appears " << frequencyMap.at(item) << " times." << endl;
	}
	else {
		cout << "The item '" << item << "' does not exist in the file." << endl;
	}
}

// Function to display all items with their frequencies
void DisplayFrequencies(const map<string, int>& frequencyMap) {
	cout << "Items and their frequencies:" << endl;
	for (const auto& pair : frequencyMap) {
		cout << setw(15) << left << pair.first << pair.second << endl;
	}
}

// Function to display the histogram
void DisplayHistogram(const map<string, int>& frequencyMap) {
	cout << "Histogram:" << endl;
	for (const auto& pair : frequencyMap) {
		cout << setw(15) << left << pair.first << string(pair.second, '*') << endl;
	}
}

// Function to create a backup file
void CreateBackupFile(const map<string, int>& frequencyMap, const string& backupFilename) {
	ofstream outFile(backupFilename);

	if (!outFile.is_open()) {
		cout << "Error: Unable to create backup file " << backupFilename << endl;
		return;
	}

	for (const auto& pair : frequencyMap) {
		outFile << pair.first << " " << pair.second << endl;
	}

	outFile.close();
	cout << "Backup file " << backupFilename << " created successfully." << endl;
}

int main() {
	const string inputFilename = "CS210_Project_Three_Input_File.txt";
	const string backupFilename = "frequency.dat";
	map<string, int> frequencyMap = CountFrequency(inputFilename);

	if (frequencyMap.empty()) {
		return 1; // Exit if the file could not be read
	}

	int choice;
	do {
		cout << "\nMenu Options:" << endl;
		cout << "1. Search for an item's frequency" << endl;
		cout << "2. Display all items with their frequencies" << endl;
		cout << "3. Display a histogram of item frequencies" << endl;
		cout << "4. Exit the program" << endl;
		cout << "Enter your choice: ";
		cin >> choice;

		switch (choice) {
		case 1:
			SearchItemFrequency(frequencyMap);
			break;
		case 2:
			DisplayFrequencies(frequencyMap);
			break;
		case 3:
			DisplayHistogram(frequencyMap);
			break;
		case 4:
			CreateBackupFile(frequencyMap, backupFilename);
			cout << "Exiting program. Goodbye!" << endl;
			break;
		default:
			cout << "Invalid choice. Please try again." << endl;
		}
	} while (choice != 4);

	return 0;
}
