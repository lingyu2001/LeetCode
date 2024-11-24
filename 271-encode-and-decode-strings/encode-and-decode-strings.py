class Codec:
    def encode(self, strs: List[str]) -> str:
        encoded = ""
        for s in strs:
            encoded += s + "<DELIMITER>"
        return encoded

    def decode(self, s: str) -> List[str]:
        return s.split("<DELIMITER>")[:-1]

