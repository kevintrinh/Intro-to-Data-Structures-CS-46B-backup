package dna;

import java.io.*;


//
// Reads lines from a BufferedReader and builds a FastqRecord.
//


public class FastqReader 
{
	private BufferedReader   theBufferedReader;

	
	public FastqReader(BufferedReader br)
	{
		this.theBufferedReader = br;
	}
	
	// Returns next record in the file, or null if EOF (end-of-file).
	public FastqRecord readRecord() throws IOException, RecordFormatException
	{
		// Read the defline from the BufferedReader. Return null if you read null, 
		// indicating end of file.
		String defline = theBufferedReader.readLine();		
		if(defline == null)
			return null;
		// Read the next 3 lines from the buffered reader. Construct and return
		// a FastqRecord.
		else {
			String sequence = theBufferedReader.readLine();
			String plusLine = theBufferedReader.readLine();
			String quality = theBufferedReader.readLine();		
			if(quality == null)
				throw new RecordFormatException("The 4 input lines don’t constitute a valid fastq record.");
			return new FastqRecord(defline, sequence, quality);
		}
	}
}
